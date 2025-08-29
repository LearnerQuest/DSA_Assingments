package Recursion;
import java.util.*;


public class RatInMaze {
    // Directions in lexicographic order: D, L, R, U
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] dir = {'D', 'L', 'R', 'U'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] maze = new int[N][N];

        // Input maze
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        List<String> result = findPaths(maze, N);

        if (result.isEmpty()) {
            System.out.println("");
        } else {
            for (String path : result) {
                System.out.print(path + " ");
            }
        }
        sc.close();
    }

    // Wrapper function
    static List<String> findPaths(int[][] maze, int N) {
        List<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];

        if (maze[0][0] == 1) {
            solve(0, 0, maze, N, visited, "", paths);
        }

        Collections.sort(paths);
        return paths;
    }

    // Recursive backtracking
    static void solve(int x, int y, int[][] maze, int N, boolean[][] visited, String path, List<String> paths) {
        // Base case: reached destination
        if (x == N - 1 && y == N - 1) {
            paths.add(path);
            return;
        }

        // Mark visited
        visited[x][y] = true;

        // Explore all 4 directions
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isSafe(newX, newY, maze, N, visited)) {
                solve(newX, newY, maze, N, visited, path + dir[i], paths);
            }
        }

        // Backtrack
        visited[x][y] = false;
    }

    // Check if a cell is valid
    static boolean isSafe(int x, int y, int[][] maze, int N, boolean[][] visited) {
        return (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1 && !visited[x][y]);
    }
}
