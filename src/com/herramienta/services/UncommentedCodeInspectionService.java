package com.herramienta.services;

/**
 * Si heredamos de esta clase, entonces vamos a poder medir metricas 
 * pero unicamente para lineas no comentadas.
 * Es importante no sobreescribir el metodo analyzeLine, sino
 * el metodo analyzeUncommentedLine.
 * */
public abstract class UncommentedCodeInspectionService extends CodeInspectionService {

	private enum State {
		Normal			, // Estado 0
		Slash			, // Estado 1
		InlineComment	, // Estado 2
		MultilineComment, // Estado 3
		PossibleEnd		  // Estado 4
	}
	
	// Atributos
	private State currentState = State.Normal;
	
	@Override
	public void analyzeLine(String codeLine) {
		String uncommentedLine = "";
		
		// Cuando termina la linea se termina el comentario inline
		// (llamo comentario inline al comentario con doble barra)
		if (this.currentState == State.InlineComment) {
			this.currentState = State.Normal;
		}
		
		for (Character c : codeLine.toCharArray()) {
			switch(this.currentState) {
			
			case Normal:
				if(c == '/') {
					this.currentState = State.Slash;
				} else {
					uncommentedLine += c;
				}
				break;
				
				
			case Slash:
				if(c == '/') {
					this.currentState = State.InlineComment;
				} else if(c == '*') {
					this.currentState = State.MultilineComment;
				} else {
					// En este caso, se trataba de una operacion de division.
					uncommentedLine += '/';
					uncommentedLine += c;
				}
				break;
				
				
			case InlineComment:
				// No podemos hacer nada
				// Es un comentario inline, todo lo que se escriba aca adentro
				// termina sin ser analizado.
				break;
				
				
			case MultilineComment:
				if (c == '*') {
					this.currentState = State.PossibleEnd;
				} else {
					// No hacemos nada mas
				}
				break;
				
				
			case PossibleEnd:
				if (c == '/') {
					this.currentState = State.Normal;
				} else {
					// Si no se trataba de un comentario multilinea puede haber sido cualquier
					// otra cosa que no terminaba con el comentario
				}
				break;
				
			}
		}
		
		this.analyzeUncommentedLine(uncommentedLine);
		
	}
	
	protected abstract void analyzeUncommentedLine(String codeline);

}
