package xadrez.backend.domain;

public final class PieceMoves {

	private PieceMoves(){}

	public static final int[] ROOK = {
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

	public static final int[] HORSE = {
		17,
		10,
		-15,
		-6,
		15,
		6,
		-17,
		-10
	};

	public static final int[] BISHOP = {
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

	public static final int[] QUEEN = {
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

	public static final int[] KING = {
		1,
		-1,
		7,
		8,
		9,
		-7,
		-8,
		-9
	};

	public static final int[] PAWN = {
		8	
	};
}
