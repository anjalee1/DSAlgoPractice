//dsu: https://www.youtube.com/watch?v=qHZxfNKUMXw
//ide:https://www.google.com/search?q=mst+using+kruskal%27s+algorithm+gfg+practice&client=firefox-b-d&sxsrf=ALiCzsZsOIyFpsNR2qCc0OZgs_trA6CRNA%3A1669036728778&ei=uHp7Y7STL5Gfmgex65LACg&oq=mst+using+kruskal%27s+algorithm+gfg&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQARgAMgUIIRCgAToFCAAQgAQ6BggAEBYQHjoICCEQFhAeEB06BwghEKABEApKBAhBGABKBAhGGABQAFjGD2CLGmgAcAF4AYABkAKIAekHkgEFMC4zLjKYAQCgAQHAAQE&sclient=gws-wiz-serp
//sol: https://takeuforward.org/data-structure/minimum-spanning-tree-mst-using-kruskals-algo/
//https://www.youtube.com/watch?v=YU3Bvek4wjs&t=509s

// Time Complexity: O(ElogE)+O(E*4*alpha), ElogE for sorting and E*4*alpha for findParent operation ‘E’ times
// Space Complexity: O(N). Parent array+Rank Array


class Solution
{
	static int[] parent, rank;

    static void make_set(int v) {
        parent[v] = v;
        rank[v] = 0;
    }
    
    //Function to find set of an element v (using path compression technique).
    static int find_set(int v) {
        if (v == parent[v])
            return v;
        return parent[v] = find_set(parent[v]);
    }
    
    //Function that does union of two sets x and y (using union by rank).
    static void union_sets(int a, int b) 
    {
        a = find_set(a);
        b = find_set(b);
        if (a != b) {
            if (rank[a] < rank[b]){
                int temp = a; a=b; b=temp;    
            }
            parent[b] = a;
            if (rank[a] == rank[b])
                rank[a]++;
        }
    }
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
	{
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<adj.get(i).size(); j++)
            {
                ArrayList<Integer> x = new ArrayList<Integer>();
                x = adj.get(i).get(j);
                
                ArrayList<Integer> temp = new ArrayList<Integer>();
                
                temp.add(x.get(1));
                temp.add(Math.min(i,x.get(0)));
                temp.add(Math.max(i,x.get(0)));
                res.add(temp);
            }
        }
        
        //sorting according to the weight of the edges.
        Collections.sort(res,new Comparator<ArrayList<Integer>>() {
             @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) 
            {
                if(Integer.compare(o1.get(0),o2.get(0))==0)
                {
                    if(Integer.compare(o1.get(1),o2.get(1))==0)
                        return Integer.compare(o1.get(2),o2.get(2));
                    return Integer.compare(o1.get(1),o2.get(1));
                }
                return Integer.compare(o1.get(0),o2.get(0));
         }});
        
        
        ArrayList<ArrayList<Integer>> graph= new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<res.size(); i+=2){
            graph.add(res.get(i));
        }
        
        int cost = 0;
        parent = new int[V+1];
        rank = new int[V+1];
        
        for (int i=0; i<V; i++)
            make_set(i);
        
        for (ArrayList<Integer> e : graph) 
        {
            //if set of e[1] and e[2] is not equal, we update cost 
            //and perform union of the two sets.
            if (find_set(e.get(1)) != find_set(e.get(2))) {
                cost += e.get(0);
                union_sets(e.get(1), e.get(2));
            }
        }
        return cost;
    }
};
