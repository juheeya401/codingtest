package DfsDfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 07-07. 이진트리 레벨탐색(BFS : Breadth-First Search)
 * #BFS #레벨탐색 #꽉찬이진트리
 * 
 * 넓게 검색!
 * 최단거리 검색
 * 큐 자료구조 사용됨
 * 간선 한 번만에 가는 곳을 1레벨, 간선을 두번 거치는 곳을 2레벨... 이렇게 말한다.
 */
public class Bfs07 {
    Bfs07.Node root;

    public static void main(String[] args) {
        Bfs07 tree = new Bfs07();
        tree.root = new Bfs07.Node(1);
        tree.root.left = new Bfs07.Node(2);
        tree.root.right = new Bfs07.Node(3);
        //tree.root.left.left = new Bfs07.Node(4);
        //tree.root.left.right = new Bfs07.Node(5);
        //tree.root.right.left = new Bfs07.Node(6);
        //tree.root.right.right = new Bfs07.Node(7);
        tree.bfs(tree.root);
    }

    private void bfs(Bfs07.Node node) {
        Queue<Node> Q = new LinkedList<>();

        // 큐에 루트 노드를 입력한다.
        Q.offer(node);

        // 첫번째 레벨 지정
        int Level = 0;

        // 큐에 데이터가 없어질 때 까지 반복!
        while(!Q.isEmpty()) {
            System.out.print(Level + ": "); // 현재 레벨 체크

            int len = Q.size(); // 현재 레벨에 있는 노드 갯수

            // 현재 레벨에 있는 노드 갯수만큼 반복해서 그 하위 노드들을 큐에 저장해 준다.
            for (int i=0; i<len; i++) {
                // 현재 레벨에서 하나씩 노드를 꺼내서
                Node current = Q.poll();

                // 문제에서 요청하는 처리를 하고
                System.out.print(current.data + " ");

                /* 현재 레벨은 작업 끝났으니까 큐의 말단에 현재 노드의 자식 노드들을 또 넣어준다.
                 * 이렇게 새로 넣어준 자식들은, 현재 레벨의 노드들의 작업이 다 끝나면 실행될 것이다.
                 * 현재 노드가 말단 노드가 아닌 경우에만 데이터 계속 입력
                 */
                if (current.left != null) Q.offer(current.left); // 현재 노드의 왼쪽노드를 큐에 저장.
                if (current.right != null) Q.offer(current.right); // 현재 노드의 오른쪽노드를 큐에 저장.
            }// 한 레벨 끝남

            Level++;
            System.out.println();
        }
    }


    static class Node {
        int data;
        Bfs07.Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
