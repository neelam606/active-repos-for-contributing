import java.util.*;

import java.lang.*;

import java.io.*;



class Codechef

{

	public static void main (String[] args) throws java.lang.Exception

	{



		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

		

		int t = Integer.parseInt(rd.readLine());

	

        for (int tc = 0; tc < t; tc++) {



			String[] n_d = rd.readLine().split(" ");



			int n = Integer.parseInt(n_d[0]);

			int d = Integer.parseInt(n_d[1]);



			int [][] arr = new int[n][3];



			for (int i = 0; i < n; i++) {

				String[] d_t_s = rd.readLine().split(" ");

				arr[i][0] = Integer.parseInt(d_t_s[0]);

				arr[i][1] = Integer.parseInt(d_t_s[1]);

				arr[i][2] = Integer.parseInt(d_t_s[2]);

			}



			Arrays.sort(arr, (a, b) -> a[0] - b[0]);

			TreeMap<Integer, Integer> mp = new TreeMap<>();



			long s = 0;



			int pt = 0;

			for (int i = 1; i <= d; i++) {

				

				while (pt < arr.length && arr[pt][0] == i) {

					if (mp.containsKey(arr[pt][2])) {

						mp.put(arr[pt][2], mp.get(arr[pt][2]) + arr[pt][1]);

					} else {

						mp.put(arr[pt][2], arr[pt][1]);

					}

					pt += 1;

				}



				if (mp.size() == 0) {

					continue;

				}



				int k = mp.lastKey();

				int val = mp.get(k);

				val -= 1;

				

				if (val == 0) {

					mp.remove(k);

				} else {

					mp.put(k, val);

				}



			}

			

			for(Map.Entry<Integer, Integer> pair: mp.entrySet()) {

				int key = pair.getKey();

				int value = pair.getValue();



				s += (long) key * (long )value;

			}

			System.out.println(s);

		}	

	}

}
