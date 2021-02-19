package shizhanthread.chapter5.concurrent.utils;

/**
 * @author moubin.mo
 * @date: 2021/2/17 10:33
 */

//public class CellularAutomata {
//	private final Board mainBoard;
//	private final CyclicBarrier barrier;
//	private final Worker[] workers;
//	class Board{}
//
//	public CellularAutomata(Board board) {
//		this.mainBoard = board;
//		int count = Runtime.getRuntime().availableProcessors() -1;
//		new CyclicBarrier(count, new Runnable() {
//			@Override
//			public void run() {
//				mainBoard.commitNewValues();
//			}
//		});
//
//		this.workers = new Worker[count];
//		for (int i=0; i<count; i++){
//			workers[i] = new Worker(mainBoard.getSubBoard(count, i));
//		}
//	}
//
//	private class Worker implements Runnable{
//		private final Board board;
//
//		public Worker(final Board board) {
//			this.board = board;
//		}
//
//		@Override
//		public void run() {
//			while (!board.hasConverged()){
//				for (int x = 0; x<board.getMaxX(); x++){
//					for (int y = 0; y < board.getMaxY(); y++){
//						board.setNewValue(x, y, computeValue(x,y));
//					}
//				}
//				try {
//					barrier.await();
//				} catch (InterruptedException e) {
//					return;
//				} catch (BrokenBarrierException e) {
//					return;
//				}
//			}
//		}
//	}
//}
