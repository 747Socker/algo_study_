import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_14503_�κ�û�ұ� {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // ����
		int m = Integer.parseInt(st.nextToken()); // ����
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		int ans = 0;
		boolean flag;
		first: while (true) {

			if (map[r][c] == 0) {
				map[r][c] = -1; // û�� ��> -1ĥ�ϱ�
				ans++;
			}
			flag = false;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (map[nr][nc] == 0) {
					flag = true;
					break;
				}

			} // �����¿� û�� �� �� ĭ�� �ִ��� Ȯ�� ��> flag

			if (flag) { // û�� ���� ĭ�� ����
				while (true) {
					dir = (dir + 3) % 4; // �ݽð���� ȸ��
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if (map[nr][nc] == 0) {
						r = nr;
						c = nc;
						break;
					} // ��ĭ ���� , �ݺ��� Ż��

				}
				continue first;

			} else { // û�Ҿ��� ĭ�� ���� ��
				int nr = r + dr[(dir + 2) % 4];
				int nc = c + dc[(dir + 2) % 4];
				if (map[nr][nc] != 1) { // ���� �����ϸ� ����
					r = nr;
					c = nc;
					continue first;
				} else { // ���� �Ұ��� ��> ��
					break first;
				}

			}

		}

		System.out.println(ans);

		br.close();
	}
}