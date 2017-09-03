

class StackX{
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX(){
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j){
        st[++top] =j;
    }
    public int pop(){
        return st[top--];
    }
    public int peek(){
        return st[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
}


class Graph{
    private final int MAX_VERTS= 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private StackX theStack;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for(int j=0;j<MAX_VERTS;j++){
            for(int k=0;k<MAX_VERTS;k++){
                adjMat[j][k]= 0;
                adjMat[k][j]= 0;
            }
        }
        theStack = new StackX();
    }

    public void addVertex(String lab){
        vertexList[nVerts++] = new Vertex(lab);
    }
    public void addEdge(int a, int b){
        adjMat[a][b] = 1;
        adjMat[b][a] = 1;
    }
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }




    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while(! theStack.isEmpty()){
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1){
                theStack.pop();
            }else{
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }//while

        for(int j=0;j<nVerts;j++){
            vertexList[j].wasVisited = false;
        }
    }// dfs

    public int getAdjUnvisitedVertex(int v){
        for(int j=0;j<nVerts;j++){
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }
}

class Vertex {
    public String label;
    public boolean wasVisited;

    public Vertex(String lab) {
        label = lab;
        wasVisited = false;
    }
}


public class DepthFirstSearch {
    public static void main(String args[]){

        Graph theGraph = new Graph();
        theGraph.addVertex("Celbridge ");
        theGraph.addVertex("Maynooth ");
        theGraph.addVertex("Lucan ");
        theGraph.addVertex("Lixlip ");
        theGraph.addVertex("Clane ");
        theGraph.addVertex("Straphan ");
        theGraph.addVertex("Santry ");
        theGraph.addVertex("LiffeyValley ");
        theGraph.addVertex("Ballemon ");
        theGraph.addVertex("Naas ");
        theGraph.addVertex("Newbridge ");

        theGraph.addEdge(0,1);
        theGraph.addEdge(1,2);
        theGraph.addEdge(2,4);
        theGraph.addEdge(2,3);
        theGraph.addEdge(0,5);
        theGraph.addEdge(5,6);
        theGraph.addEdge(6,7);
        theGraph.addEdge(6,8);
        theGraph.addEdge(7,9);
        theGraph.addEdge(9,10);

        System.out.print("Visits: ");
        theGraph.dfs();
        System.out.println();




    }
}
