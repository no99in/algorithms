package Main;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static boolean isFinalStep(Deque<Station> dist) {
		if (dist.size() == 6) {
			return true;
		}
		return false;
	}

	public static void printEveryStep(Deque<Station> dist) {
		int res = 0;
		int prevBelong = 0;
		for (Station station : dist) {
			if (station == dist.getFirst()) {
				res += station.enTime;
				res += station.processTime;
			}
			if (station != dist.getFirst() && prevBelong == station.belong) {
				res += station.processTime;
			}
			if (station != dist.getFirst() && prevBelong != station.belong) {
				res += station.enTime;
				res += station.processTime;
			}
			if (station == dist.getLast()) {
				res += station.deTime;
			}
			prevBelong = station.belong;

			System.out.print(station.processTime + "=>");

		}

		System.out.println(res);
	}

	// 深度优先
	public static void deepFirstSearch(Deque<Station> dist,
			Vector<Station> oldStationLine, Vector<Station> newStationLine) {

		if (isFinalStep(dist)) {
			printEveryStep(dist);
			return;
		}

		Station curStation = dist.peekLast();
		if (curStation == null || dist.size() == 0) {
			dist.offer(oldStationLine.get(0));
			deepFirstSearch(dist, oldStationLine, newStationLine);
			dist.poll();
			dist.offer(newStationLine.get(0));
			deepFirstSearch(dist, oldStationLine, newStationLine);
			dist.poll();
		} else {
			dist.offerLast(oldStationLine.get(dist.size()));
			deepFirstSearch(dist, oldStationLine, newStationLine);
			dist.pollLast();
			dist.offerLast(newStationLine.get(dist.size()));
			deepFirstSearch(dist, oldStationLine, newStationLine);
			dist.pollLast();
		}

	}

	public static void main(String[] args) {

		// 初始化
		int OLD_BELONG = 0;
		int NEW_BELONG = 0;
		
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

		// 算法这里执行
		Deque<Station> dist = new LinkedList<Station>();
		deepFirstSearch(dist, oldStationLine, newStationLine);

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
	}

}
