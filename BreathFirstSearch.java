package breed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Vertex{
	String state;
	boolean wasVisited;
	
	public Vertex(String state){
		this.state = state;
		wasVisited = false;
	}
}


class Graph{
	ArrayList <Vertex> vertexList;
	int adjMat[][];
	int maxSize = 20;
	Queue <Integer> theQue;
	
	public Graph(){
		vertexList = new ArrayList<>();
		adjMat = new int [maxSize][maxSize];
		
		
		for(int j=0;j<maxSize;j++){
			for(int k=0;k<maxSize;k++){
				adjMat[j][k]=0;
				adjMat[k][j]=0;
			}
		}
		
		theQue = new LinkedList<>();
	}
	
	public void addVertex(String state){
		vertexList.add(new Vertex(state));
	}
	public void addEdge(int a,int b){
		adjMat[a][b]= 1;
		adjMat[b][a]= 1;
	}
	public void display(int c){
		System.out.println(vertexList.get(c).state);
	}
	
	public int getAdjVertex(int c){
		int count = vertexList.size();
		for(int j=0;j<count;j++){
			if(adjMat[c][j] == 1 && vertexList.get(j).wasVisited== false){
				return j;
			}
		}
		return -1;
	}
	
	public void bfs(){
		vertexList.get(0).wasVisited = true;
		display(0);
		theQue.add(0);
		int v2;
		
		
		while(! theQue.isEmpty()){
			int v1 = theQue.remove();
			
			while((v2 = getAdjVertex(v1)) != -1){
				vertexList.get(v2).wasVisited = true;
				display(v2);
				theQue.add(v2);
			}
		}
		
		
		
	}
	
	
	
}












public class BreathFirstSearch {

	public static void main(String[] args) {
	
		
	Graph theGraph = new Graph();
		
		theGraph.addVertex("New York");
		theGraph.addVertex("Boston");
		theGraph.addVertex("Califorina");
		theGraph.addVertex("Washington");
		theGraph.addVertex("Texus");
		theGraph.addVertex("Montana");
		theGraph.addVertex("Origan");
		theGraph.addVertex("Canada");
		theGraph.addVertex("Mexico");
		theGraph.addVertex("Brazil");
		
		theGraph.addEdge(0,1);
		theGraph.addEdge(1,2);
		theGraph.addEdge(2,3);
		theGraph.addEdge(0,4);
		theGraph.addEdge(4,5);
		theGraph.addEdge(5,6);
		theGraph.addEdge(0,7);
		theGraph.addEdge(7,8);
		theGraph.addEdge(8,9);
		
		
		
		System.out.print("Visites: ");
		theGraph.bfs();
		System.out.println();
		
		

	}

}
