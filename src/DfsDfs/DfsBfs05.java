package DfsDfs;

/**
 * 07-05. 이진트리순회(DFS : Depth-First Search)
 * #DFS #깊이우선탐색 #DFS탐색하는방법
 * #이진트리기본⭐️ -> 앞으로 할 알고리즘에서 많이 활용될 개념!
 *
 * 전위순회: root -> 왼 -> 오른쪽 순서대로 방문하는 방법
 *   - 출력: 1 2 4 5 3 6 7
 * 중위순회: 자식 -> root -> 자식
 *   - 출력: 4 2 5 1 6 3 7
 * 후위순회: 자식 -> 자식 -> root (병합정렬 시 사용됨)
 *   - 출력: 4 5 2 6 7 3 1
 */
public class DfsBfs05 {

    Node root;

    public static void main(String[] args) {
        DfsBfs05 tree = new DfsBfs05();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.dfs(tree.root);
    }

    private void dfs(Node node) {
        // 최 말단 노드(null)면 반환
        if (node == null) return;
        else {
            // 왼쪽 자식노드부터 깊게 깊게 탐색 (재귀) => 가장 왼쪽의 말단 자식부터 실행된다.

            //System.out.print(node.data + " "); // 전위순회
            dfs(node.left);
            //System.out.print(node.data + " "); // 중위순회
            dfs(node.right);
            System.out.print(node.data + " "); // 후위순회
        }
    }




    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
