package Main;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static boolean isFinalState(Vector<Bucket> curState) {
		if (curState.get(0).water == 4 && curState.get(1).water == 4) {
			return true;
		}
		return false;
	}

	public static boolean isCanDoState(Vector<Bucket> curState, Action curAct) {

		if (curState.get(curAct.from).water > 0
				&& curState.get(curAct.to).capicity > curState.get(curAct.to).water) {
			return true;
		}
		return false;
	}

	public static boolean isDoState(Vector<Bucket> curState,
			Deque<Vector<Bucket>> dist) {

		for (Vector<Bucket> state : dist) {
			int flg = 0;
			for (int i = 0; i < 3; i++) {

				if (state.get(i).water != curState.get(i).water) {
					flg = 1;
				}

			}
			if (flg == 1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void deeoFirstSearch(Deque<Vector<Bucket>> dist,
			Vector<Action> act) {
		Vector<Bucket> curState = dist.getLast();
		if (isFinalState(curState)) {
			for (Vector<Bucket> state : dist) {
				System.out.print("[");
				for (Bucket bucket : state) {
					System.out.print(bucket.water + " ");
				}
				System.out.println("]");
			}
			return;
		}

		for (Action curAct : act) {
			if (isCanDoState(curState, curAct)) {
				Vector<Bucket> newState = new Vector<Bucket>();
				try {
					newState.addElement((Bucket) curState.get(0).clone());
					newState.addElement((Bucket) curState.get(1).clone());
					newState.addElement((Bucket) curState.get(2).clone());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}

				int rest = newState.get(curAct.to).capicity
						- newState.get(curAct.to).water;

				if (newState.get(curAct.from).water <= rest) {
					newState.get(curAct.to).water += newState.get(curAct.from).water;
					newState.get(curAct.from).water = 0;
				} else {
					newState.get(curAct.to).water = newState.get(curAct.to).capicity;
					newState.get(curAct.from).water -= rest;
				}

				if (isDoState(newState, dist)) {
					dist.offerLast(newState);
					deeoFirstSearch(dist, act);
					dist.pollLast();
				}
			}
		}

	}

	public static void main(String[] args) {

		// 初始化
		Vector<Bucket> state = new Vector<Bucket>();
		state.addElement(new Bucket(8, 8));
		state.addElement(new Bucket(0, 5));
		state.addElement(new Bucket(0, 3));

		Vector<Action> act = new Vector<Action>();
		act.addElement(new Action(0, 1));
		act.addElement(new Action(0, 2));
		act.addElement(new Action(1, 0));
		act.addElement(new Action(1, 2));
		act.addElement(new Action(2, 0));
		act.addElement(new Action(2, 1));

		// 深度
		Deque<Vector<Bucket>> dist = new LinkedList<Vector<Bucket>>();
		dist.offerFirst(state);
		deeoFirstSearch(dist, act);

	}
}

class Action {

	int from;
	int to;
	int water;

	public Action(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

}

class Bucket implements Cloneable {

	int water;
	int capicity;

	public Bucket(int water, int capicity) {
		super();
		this.water = water;
		this.capicity = capicity;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
