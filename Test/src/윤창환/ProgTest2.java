package À±Ã¢È¯;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {
	Map<String, MemberData> mapList = new Hashtable<>();

	void mapListAdd(String memberID, String name, String tel, String gender) {
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));
	}

	void mapListRemove(String memberID) {
		mapList.remove(memberID);
	}

	ArrayList<MemberData> getMapLIst() {
		ArrayList<MemberData> list = new ArrayList<>();

		Set<String> keyset = mapList.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		while (keyiterator.hasNext()) {
			String s = keyiterator.next();
			MemberData m = mapList.get(s);
			list.add(m);

		}
		return list;
	}
}