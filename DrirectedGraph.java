package ThucHanhBuoi1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import ThucHanhBuoi2.ReadFile;

import java.util.Set;

public class DrirectedGraph extends Graph {

	@Override
	public void addVertex(String v) {
		Set<String> a = new HashSet<>();
		this.adjList.put(v, a);

	}

	@Override
	public void removeVertex(String v) {
		Iterator<Map.Entry<String, Set<String>>> iterator = adjList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Set<String>> entry = iterator.next();
			if (entry.getKey().equals(v)) {
				iterator.remove();
			} else {
				Set<String> values = entry.getValue();
				Iterator<String> valueIterator = values.iterator();
				while (valueIterator.hasNext()) {
					String value = valueIterator.next();
					if (value.equals(v)) {
						valueIterator.remove();
					}
				}
			}
		}
	}

	@Override
	public void addEdge(String u, String v) {
		if (this.adjList.containsKey(u) && this.adjList.containsKey(v)) {
			this.adjList.get(u).add(v);

		} else {

		}
	}

	@Override
	public void removeEdge(String u, String v) {
		if (this.adjList.containsKey(u) && this.adjList.containsKey(v)) {
			this.adjList.get(u).remove(v);
		} else {

		}

	}

	@Override
	public int edges() {
		int sum = 0;
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			String a = entry.getKey();
			sum += Outdegree(a);
		}
		return sum;

	}

	@Override
	public int degree(String v) {
		return 0;
	}

	public int Outdegree(String v) {
		
		return adjList.get(v).size();

	}

	public int Indegree(String v) {
		int res = 0;
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			for (String a : entry.getValue()) {
				if (a.equals(v)) {
					res++;
				}
			}
		}

		return res;

	}
	public static ArrayList<String> read (String url){
		int v = 0 ;
		ArrayList<String> result = new ArrayList<>();
		File file = new File(url) ;
		try {
			FileReader reader = new FileReader(file) ;
			BufferedReader buffer = new BufferedReader(reader);
			String line = buffer.readLine();
			v = Integer.parseInt(line) ;
			line = buffer.readLine();
			while (line != null) {
				result.add(line);
				line = buffer.readLine();
			}
			
			
			
		} catch (Exception e) {
        e.printStackTrace();
        
		}
		return result;
	}
	public void addInAdjList () {
	    ArrayList<String> arr = ReadFile.read("./dsdt.txt");
	    String[][] matrix = new String[arr.size()][];

	    for (int i = 0; i < arr.size(); i++) {
	        String line = arr.get(i);
	        String[] elements = line.split(" ");

	        matrix[i] = elements;
	    }

	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	           System.out.print(matrix[i][j]);
	           
	           
	        }
	        System.out.println(); 
	    }
	}
	public static void main(String[] args) {
		ReadFile rd = new ReadFile();
		rd.print();
	}

	@Override
	public Boolean checkSingleGraph() {
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			String keys = entry.getKey();
			Set<String> value = entry.getValue();
			for (String values : value) {
				if (keys.equals(values)) {
					return false ;
				}
			}
		}
		return true;
	}

	
	@Override
	public void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true ;
		queue.add(v);
		while (!queue.isEmpty()) {
			v = queue.poll();
			System.out.println(v + " ");
			
		}
		
	}

	

}
