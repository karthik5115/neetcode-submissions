class Solution {

    boolean isAllEqual(Node topLeft, Node topRight,
                       Node botLeft, Node botRight) {

        return topLeft.isLeaf &&
               topRight.isLeaf &&
               botLeft.isLeaf &&
               botRight.isLeaf &&
               topLeft.val == topRight.val &&
               topRight.val == botLeft.val &&
               botLeft.val == botRight.val;
    }

    public Node recursion(int startx, int starty,
                          int endx, int endy,
                          int[][] grid) {

        // Single cell
        if (startx == endx && starty == endy) {
            return new Node(grid[startx][starty] == 1, true);
        }

        int midx = startx + (endx - startx) / 2;
        int midy = starty + (endy - starty) / 2;

        Node topLeft = recursion(
            startx, starty,
            midx, midy,
            grid
        );

        Node topRight = recursion(
            startx, midy + 1,
            midx, endy,
            grid
        );

        Node botLeft = recursion(
            midx + 1, starty,
            endx, midy,
            grid
        );

        Node botRight = recursion(
            midx + 1, midy + 1,
            endx, endy,
            grid
        );

        // If all four children are identical leaves,
        // merge them into one leaf.
        if (isAllEqual(topLeft, topRight, botLeft, botRight)) {
            return new Node(topLeft.val, true);
        }

        // Otherwise create an internal node
        return new Node(
            true,
            false,
            topLeft,
            topRight,
            botLeft,
            botRight
        );
    }

    public Node construct(int[][] grid) {
        return recursion(
            0,
            0,
            grid.length - 1,
            grid.length - 1,
            grid
        );
    }
}