package Crypterzeug;

public enum Enum {
	
	CAESAR(65,90), SUBSTITUTION(65,90), REVERSE(65,90), XOR(65,90), NULL(65,90);

	private final int ersterBuchstabe;
	private final int letzterBuchstabe;

	private Enum(int ersterBuchstabe, int letzterBuchstabe) {
		this.ersterBuchstabe = ersterBuchstabe;
		this.letzterBuchstabe = letzterBuchstabe;

		
	}
	
}
