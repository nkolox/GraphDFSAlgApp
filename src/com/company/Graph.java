package com.company;

/**
 * Created by LocalAdm on 22.09.2018.
 */
public class Graph {
    private final int NUM_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int currentVerts;
    private int size;
    private Stack vertsStack;

    public Graph()
    {
        size = NUM_VERTS;
        vertexList = new Vertex[size];
        adjacencyMatrix = new int[size][size];
        currentVerts = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                adjacencyMatrix[i][j] = 0;
        vertsStack = new Stack(size);
    }

    public Graph(int size)
    {
        this.size = size;
        vertexList = new Vertex[size];
        adjacencyMatrix = new int[size][size];
        currentVerts = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                adjacencyMatrix[i][j] = 0;
        vertsStack = new Stack();
    }

    public void addVertex(char value)
    {
        vertexList[currentVerts++] = new Vertex(value);
    }

    public void addEdge(int start, int end)
    {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public int getUnvisitedVertex(int v)
    {
        for (int k = 0; k < currentVerts; k++)
            if(adjacencyMatrix[v][k] == 1 && vertexList[k].isVisited == false)
            {
                return k;
            }
            return -1;
    }

    public void DepthFirstGraph()
    {
        vertexList[0].isVisited = true;
        showVertex(0);
        vertsStack.push(0);

        while (!vertsStack.isEmpty())
        {
            int adjVertex = getUnvisitedVertex(vertsStack.peek());
            if(adjVertex == -1)
            {
                vertsStack.pop();
            }
            else
            {
                vertexList[adjVertex].isVisited = true;
                vertsStack.show();
                vertsStack.push(adjVertex);
            }
        }

        for(int k = 0; k < currentVerts; k++)
            vertexList[k].isVisited = false;
    }

    public void showVertex(int num)
    {
        System.out.print(vertexList[num].value);
    }
}
