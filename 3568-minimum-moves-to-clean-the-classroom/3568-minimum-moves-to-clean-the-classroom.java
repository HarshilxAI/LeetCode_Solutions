import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        ArrayList<int[]> litter = new ArrayList<>();

        int startRow = 0;
        int startCol = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (ch == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }

        int totalLitter = litter.size();

        if (totalLitter == 0) {
            return 0;
        }

        int allCollected = (1 << totalLitter) - 1;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << totalLitter];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            startRow,
            startCol,
            energy,
            0,
            0
        });

        visited[startRow][startCol][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int currEnergy = current[2];
            int mask = current[3];
            int moves = current[4];

            if (mask == allCollected) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {

                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                if (currEnergy == 0) {
                    continue;
                }

                int newEnergy = currEnergy - 1;

                char cell = classroom[nr].charAt(nc);

                if (cell == 'R') {
                    newEnergy = energy;
                }

                int newMask = mask;

                if (cell == 'L') {

                    for (int i = 0; i < totalLitter; i++) {

                        if (litter.get(i)[0] == nr &&
                            litter.get(i)[1] == nc) {

                            newMask = newMask | (1 << i);
                            break;
                        }
                    }
                }

                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}