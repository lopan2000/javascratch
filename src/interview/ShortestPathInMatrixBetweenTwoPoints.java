package interview;

import java.util.*;

public class ShortestPathInMatrixBetweenTwoPoints {

    private static final int VISITED = -1;
    private static final int[] TFS = new int[]{-1,0,1,0,-1};
    private int[][] matrix;
    private int m, n;

    private List<Coord> findShortestPath(int[][] matrix, Coord a, Coord b) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
        matrix[a.x][a.y] = VISITED;
        Deque<Coord> queue = new ArrayDeque<Coord>();
        queue.offer(a);
        while (!queue.isEmpty()) {
            Coord node = queue.poll();
            if (node.equals(b)) {
                return getPath(node);
            }
            for (Coord neighbor : getNeighbors(node)) {
                int r = neighbor.x, c = neighbor.y;
                matrix[r][c] = VISITED;
                queue.offer(neighbor);
            }
        }
        return List.of();
    }

    private List<Coord> getNeighbors(Coord node) {
        List<Coord> neighbors = new ArrayList<>();
        int r = node.x, c = node.y;
        for (int i = 0; i < 4; i++) {
            int nr = r + TFS[i];
            int nc = c + TFS[i+1];
            if (nr < 0 || nr > m-1 || nc < 0 || nc > n-1 ||
                    matrix[nr][nc] == VISITED) {
                continue;
            }
            neighbors.add(new Coord(nr,nc,node));
        }
        return neighbors;
    }

    private List<Coord> getPath(Coord targetNode) {
        Deque<Coord> path = new ArrayDeque<>();
        Coord currNode = targetNode;
        while (currNode != null) {
            path.offerFirst(currNode);
            currNode = currNode.parent;
        }
        return new ArrayList<>(path);
    }

    private static class Coord {
        public int x, y;
        public Coord parent;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Coord(int x, int y, Coord parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(x).append(",")
                    .append(y).append(")");
            return sb.toString();
        }
        @Override
        public boolean equals(Object other) {
            return this.x == ((Coord) other).x &&
                    this.y == ((Coord) other).y;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
        };
        System.out.println(new ShortestPathInMatrixBetweenTwoPoints().
                findShortestPath(matrix, new Coord(0,1), new Coord(3,3)));
    }
}