import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new LinkedList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        int visitedElements = 0;

        int y = 0, x = 0, startHeight = 0, startWidth = 0;
        Direction direction = Direction.RIGHT;
        int size = height*width;

        while (visitedElements < size) {
            visitedElements++;
            rst.add(matrix[y][x]);
            switch (direction) {
                case RIGHT -> {
                    if (x < width - 1)
                        x++;
                    else {
                        direction = Direction.BOTTOM;
                        startHeight++;
                        y++;
                    }
                }
                case BOTTOM -> {
                    if (y < height - 1)
                        y++;
                    else {
                        direction = Direction.LEFT;
                        width--;
                        x--;
                    }
                }
                case LEFT -> {
                    if (x > startWidth)
                        x--;
                    else {
                        direction = Direction.TOP;
                        height--;
                        y--;
                    }
                }
                case TOP -> {
                    if (y > startHeight)
                        y--;
                    else {
                        direction = Direction.RIGHT;
                        startWidth++;
                        x++;
                    }
                }
            }
        }

        return rst;
    }

    private enum Direction {
        RIGHT,
        LEFT,
        TOP,
        BOTTOM
    }
}