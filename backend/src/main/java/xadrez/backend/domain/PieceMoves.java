package xadrez.backend.domain;

public final class PieceMoves {

	private PieceMoves(){}
	
	public static int[] getMoves(char piece){
			switch(piece){
				case 'r':
					return new int[] {
						1,
						2,
						3,
						4,
						5,
						6,
						7,
						-1,
						-2,
						-3,
						-4,
						-5,
						-6,
						-7,
						8,
						16,
						24,
						32,
						40,
						48,
						56,
						-8,
						-16,
						-24,
						-32,
						-40,
						-48,
						-56
					};
				case 'h':
					return new int[] {
						17,
						10,
						-15,
						-6,
						15,
						6,
						-17,
						-10
					};
				case 'b':
					return new int[] {
						9,
						18,
						27,
						36,
						45,
						56,
						63,
						7,
						14,
						21,
						28,
						35,
						42,
						49,
						-9,
						-18,
						-27,
						-36,
						-45,
						-56,
						-63,
						-7,
						-14,
						-21,
						-28,
						-35,
						-42,
						-49

					};
				case 'q':
					return new int[] {
						1,
						2,
						3,
						4,
						5,
						6,
						7,
						-1,
						-2,
						-3,
						-4,
						-5,
						-6,
						-7,
						8,
						16,
						24,
						32,
						40,
						48,
						56,
						-8,
						-16,
						-24,
						-32,
						-40,
						-48,
						-56,
						9,
						18,
						27,
						36,
						45,
						56,
						63,
						7,
						14,
						21,
						28,
						35,
						42,
						49,
						-9,
						-18,
						-27,
						-36,
						-45,
						-56,
						-63,
						-7,
						-14,
						-21,
						-28,
						-35,
						-42,
						-49
					};
				case 'k':
					return new int[] {
						1,
						-1,
						7,
						8,
						9,
						-7,
						-8,
						-9
					};
				case 'p':
					return new int[] {
						8	
					};
				default:
					return new int[] {};
			}
	}
}
