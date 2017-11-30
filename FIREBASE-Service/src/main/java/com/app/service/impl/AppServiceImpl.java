package com.app.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.app.service.IAppService;

@Service
public class AppServiceImpl implements IAppService {

	public List<String> getFireBaseMovies() {
		List<String> list = new ArrayList<String>();
		String output;
		HttpURLConnection conn = null;
		try {
			URL url = new URL("https://recommendation-system-afa14.firebaseio.com/.json");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {

				JSONObject jsonObj = new JSONObject(output);
				JSONArray[] jsonArray = new JSONArray[jsonObj.length()];

				for (int i = 0; i < jsonObj.length(); i++) {
					jsonArray[i] = jsonObj.getJSONArray(jsonObj.names().optString(i));
				}

				for (int k = 0; k < jsonObj.length(); k++) {
					for (int l = 0; l < jsonArray[k].length(); l++) {
						list.add(jsonArray[k].getString(l));
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();

		}

		return list;
	}

	public int getMoviesCount(String Name) {
		List<String> movieList = getFireBaseMovies();
		Hashtable<String, Integer> Hset = new Hashtable<String, Integer>();
		// Hashtable<String, Integer> Fset = new Hashtable<String, Integer>();
		Map<String, Integer> Fset = new HashMap<String, Integer>();
		Set<String> unique = new HashSet<String>(movieList);
		for (String key : unique) {
			// System.out.println(key + ": " + Collections.frequency(movieList, key));
			Hset.put(key.toLowerCase(), Collections.frequency(movieList, key));

		}

		String a = Name.toLowerCase();

		// String str1 = a;
		String str = a;
		String[] j = str.split("\\s+");

		int count = 0;
		for (String s : j) {
			for (String key : Hset.keySet()) {

				if (Pattern.compile(s).matcher(key).find()) {

					Fset.put(key, count++);

				}

			}

		}

		Set<Entry<String, Integer>> set = Fset.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		Map<String, Integer> aMap2 = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			aMap2.put(entry.getKey(), entry.getValue());
		}

		// for(Entry<String,Integer> entry : aMap2.entrySet()) {
		// System.out.println(entry.getKey() + " - " + entry.getValue());
		//
		// }

		final Set<Entry<String, Integer>> mapValues = aMap2.entrySet();
		final int maplength = mapValues.size();
		final Entry<Integer, String>[] test = new Entry[maplength];
		mapValues.toArray(test);

		System.out.println("Here is your size of patern matching" + test[0].getKey());

		// System.out.println("Here is your size of patern matching"+rrrrrr.length());

		if (aMap2.size() != 0) {
			return Hset.get(test[0].getKey());
		} else {

			return 1;

		}

	}

}
