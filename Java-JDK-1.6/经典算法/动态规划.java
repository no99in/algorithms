package Main;

import java.util.Vector;

public class Main {

	public static void dp(Vector<Vector<Integer>> dpRes,
			Vector<Station> oldStationLine, Vector<Station> newStationLine) {

		dpRes.get(0).addElement(
				oldStationLine.get(0).enTime
						+ oldStationLine.get(0).processTime);
		dpRes.get(1).addElement(
				newStationLine.get(0).enTime
						+ newStationLine.get(0).processTime);

		for (int i = 1; i < oldStationLine.size(); i++) {

			if ((dpRes.get(0).get(i - 1) + oldStationLine.get(i).processTime) <= (dpRes
					.get(1).get(i - 1) + oldStationLine.get(i).enTime + oldStationLine
					.get(i).processTime)) {

				dpRes.get(0).addElement(
						dpRes.get(0).get(i - 1)
								+ oldStationLine.get(i).processTime);

			} else {

				dpRes.get(0).addElement(
						dpRes.get(1).get(i - 1) + oldStationLine.get(i).enTime
								+ oldStationLine.get(i).processTime);

			}
			if ((dpRes.get(1).get(i - 1) + newStationLine.get(i).processTime) <= (dpRes
					.get(0).get(i - 1) + newStationLine.get(i).enTime + newStationLine
					.get(i).processTime)) {

				dpRes.get(1).addElement(
						dpRes.get(1).get(i - 1)
								+ newStationLine.get(i).processTime);

			} else {

				dpRes.get(1).addElement(
						dpRes.get(0).get(i - 1) + newStationLine.get(i).enTime
								+ newStationLine.get(i).processTime);

			}

		}

		System.out.println(dpRes.get(0).get(oldStationLine.size() - 1)
				+ oldStationLine.get(oldStationLine.size() - 1).deTime);

		System.out.println(dpRes.get(1).get(oldStationLine.size() - 1)
				+ newStationLine.get(oldStationLine.size() - 1).deTime);
		
	}

	public static void main(String[] args) {

		// 初始化
		int OLD_BELONG = 0;
		int NEW_BELONG = 1;

		Vector<Station> oldStationLine = new Vector<Station>();
		Vector<Station> newStationLine = new Vector<Station>();

		oldStationLine.addElement(new Station(2, 7, 2, OLD_BELONG));
		oldStationLine.addElement(new Station(2, 9, 3, OLD_BELONG));
		oldStationLine.addElement(new Station(1, 3, 1, OLD_BELONG));
		oldStationLine.addElement(new Station(2, 4, 3, OLD_BELONG));
		oldStationLine.addElement(new Station(2, 8, 4, OLD_BELONG));
		oldStationLine.addElement(new Station(1, 4, 3, OLD_BELONG));

		newStationLine.addElement(new Station(4, 8, 2, NEW_BELONG));
		newStationLine.addElement(new Station(2, 5, 1, NEW_BELONG));
		newStationLine.addElement(new Station(3, 6, 2, NEW_BELONG));
		newStationLine.addElement(new Station(1, 4, 2, NEW_BELONG));
		newStationLine.addElement(new Station(3, 5, 1, NEW_BELONG));
		newStationLine.addElement(new Station(4, 7, 2, NEW_BELONG));

		Vector<Vector<Integer>> dpRes = new Vector<Vector<Integer>>();
		dpRes.addElement(new Vector<Integer>());
		dpRes.addElement(new Vector<Integer>());
		dp(dpRes, oldStationLine, newStationLine);

	}

}

class Station {

	public int enTime;
	public int processTime;
	public int deTime;
	public int belong;

	public Station(int enTime, int processTime, int deTime, int belong) {
		super();
		this.enTime = enTime;
		this.processTime = processTime;
		this.deTime = deTime;
		this.belong = belong;
	}

}
