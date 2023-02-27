package problem_427;

class Solution {
    public Node construct(int[][] grid) {
        return constructRecursion(grid, 0, 0, grid.length);
    }

    private Node constructRecursion(int[][] grid, int x, int y, int n) {
        if (n == 1) {
            return new Node((grid[y][x] == 1), true);
        }

        Node lu = constructRecursion(grid, x, y, n / 2);
        Node ru = constructRecursion(grid, x + n / 2, y, n / 2);
        Node rd = constructRecursion(grid, x + n / 2, y + n / 2, n / 2);
        Node ld = constructRecursion(grid, x, y  + n / 2, n / 2);

        if (lu.isLeaf && ru.isLeaf && rd.isLeaf && ld.isLeaf &&
                lu.val == ru.val && ru.val == rd.val && rd.val == ld.val) {
            return new Node(lu.val, true);
        }
        return new Node(
                true, // any value
                false,
                lu,
                ru,
                ld,
                rd
        );
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
}

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/