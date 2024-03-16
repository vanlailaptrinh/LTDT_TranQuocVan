package ThucHanhBuoi1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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
		int sum = 0;
		for (Map.Entry<String, Set<String>> entry : adjList.entrySet()) {
			if (entry.getKey().equals(v)) {
				sum += entry.getValue().size();
			}

		}
		return sum;

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

}
