package org.example.chap11;


// n^2 따라서 list 방식이 속도가 더 빠르다
public class GraphMatrix {

    public static final int MAX = 50; // 최대 정점 수

    // 정점들을 모아 놓을 배열
    private Vertex[] vertices;

    // 그래프의 이동방향을 기록한 2차원 배열
    private  int[][] ajdMatrix;

    // 실제로 저장된 정줌 수를 기록할 필드
    private int numOfVertices;

    public GraphMatrix() {
        vertices = new Vertex[MAX];
        ajdMatrix = new int[MAX][MAX];
    }

    // 그래프의 정점을 추가하는 메서드
    public void addVertex(Vertex v) {
        // 정점 객체에 id 부여하기
        v.setId(numOfVertices);

        // 정점 배열에 추가
        vertices[numOfVertices++] = v;
    }

    // 간선 연결하기 (무방향 그래프)
    public void addEdge(Vertex departure, Vertex destination) {

        // 인접행렬에 그래프 이동경로 저장
        ajdMatrix[departure.getId()][destination.getId()] = 1; // 출발지에서 도착지 연결
        ajdMatrix[destination.getId()][departure.getId()] = 1; // 도착지에서 출발지 연결

    }
    // 인접 행렬 출력
    public void showGraph() {
        System.out.print("    ");
        for (int i = 0; i < numOfVertices; i++) {
            System.out.print(vertices[i].getData() + " ");
        }
        System.out.println();

        for (int i = 0; i < numOfVertices; i++) {
            System.out.printf("%s | ", vertices[i].getData());
            for (int j = 0; j < numOfVertices; j++) {
                System.out.printf("%d ", ajdMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
