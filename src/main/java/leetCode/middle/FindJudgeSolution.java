package leetCode.middle;

/**
 * @author moubin.mo
 * @date: 2019/9/13 19:39
 */

public class FindJudgeSolution {

	public static void main(String[] args) {
		int N = 3;
		int[][] trust = {{1, 3}, {2, 3}};

		int result = findJudge(N, trust);
		System.out.println("result = " + result);

	}

	public static int findJudge(int N, int[][] trust) {
		int[] person = new int[N + 1];//统计出入度
		for (int[] index : trust) {
			person[index[0]]--;//出度--
			person[index[1]]++;//入度++
		}
		for (int i = 1; i <= N; i++) {
			if (person[i] == N - 1) return i;
		}
		return -1;
	}
}
