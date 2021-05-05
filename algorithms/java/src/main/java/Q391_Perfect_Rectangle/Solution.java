package q391_perfect_rectangle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {

    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE, X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;
        Set<Point> points = new HashSet<>();
        int actualArea = 0;
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            X1 = Math.min(X1, x1);
            Y1 = Math.min(Y1, y1);
            X2 = Math.max(X2, x2);
            Y2 = Math.max(Y2, y2);
            actualArea += (x2 - x1) * (y2 - y1);

            Point p1 = new Point(x1, y1), p2 = new Point(x1, y2), p3 = new Point(x2, y1), p4 = new Point(x2, y2);
            for (Point p : new Point[]{p1, p2, p3, p4}) {
                if (points.contains(p)) points.remove(p);
                else points.add(p);
            }
        }

        int expectedArea = (X2 - X1) * (Y2 - Y1);
        if (expectedArea != actualArea) return false;
        if (points.size() != 4) return false;
        if (!points.contains(new Point(X1, Y1))) return false;
        if (!points.contains(new Point(X1, Y2))) return false;
        if (!points.contains(new Point(X2, Y1))) return false;
        if (!points.contains(new Point(X2, Y2))) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
        System.out.println(solution.isRectangleCover(new int[][]{{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}}));
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
