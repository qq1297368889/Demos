package gzb.tools;

import java.util.List;

public class ListPage { 
	private int count;
	private int page;
	private int limit;
	private List<?>list;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	} 
	@Override
	public String toString() { 
		return toJson("");
	}
	public String toJson() { 
		return toJson("ok");
	}
	public String toJson(String msg){ 
		return "{"
				+ "\"state\":\"1\","
				+ "\"code\":\"0\","
				+ "\"msg\":\""+msg+"\","
				+ "\"page\":\""+page+"\","
				+ "\"limit\":\""+limit+"\","
				+ "\"count\":\""+count+"\","
				+ "\"data\":"+list.toString()+""
				+ "}";
	}

}
