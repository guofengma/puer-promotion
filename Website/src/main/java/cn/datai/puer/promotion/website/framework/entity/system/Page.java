package cn.datai.puer.promotion.website.framework.entity.system;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 分页实体对象，包含了详细的数据信息，包括分页相关信息。
 * 
 * @author wc
 * @date 2015-5-7
 *
 */
public class Page<T> {

	public static String CURRENT_INDEX = "currentIndex";
	public static String PAGE_SIZE = "pageSize";
	
	/**
	 * 当前页
	 */
	private int currentIndex;
	
	/**
	 * 每页记录数
	 */
	private int pageSize;
	
	/**
	 * 总记录数
	 */
	private int totalNumber;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 下一页
	 */
	private int nextIndex;
	
	/**
	 * 上一页
	 */
	private int preIndex;
	
	/**
	 * 当前页的数据记录
	 */
	private List<T> items;
	
	/**
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param totalNumber
	 * @param currentIndex
	 * @param pageSize
	 * @param items
	 */
	public Page(int totalNumber, int currentIndex, int pageSize, List<T> items){
		this.totalNumber = totalNumber;
		this.currentIndex = currentIndex;
		this.pageSize = pageSize;
		this.items = items;
	}
	
	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	/**
	 * @param currentIndex
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	/**
	 * @return
	 */
	public int getTotalNumber() {
		return totalNumber;
	}
	
	/**
	 * @param totalNumber
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	/**
	 * 总页数
	 * @return
	 */
	public int getTotalPage() {
		
		int size = this.totalNumber/this.pageSize;
		if(this.totalNumber%this.pageSize != 0){
			size = size + 1;
		}
		this.totalPage = size;
		
		return this.totalPage;
	}

	/**
	 * 当前页的下一页，如果当前耶大于等于最后一页
	 * 那么下一页就是最后一页。
	 * 
	 * @return
	 */
	public int getNextIndex() {
		
		if(this.currentIndex >= this.totalPage){
			this.nextIndex = this.currentIndex;
		}else{
			this.nextIndex = this.currentIndex + 1;
		}
		return nextIndex;
	}

	/**
	 * 当前页的上一页，如果当前页小于第一页那么上一页为0
	 * @return
	 */
	public int getPreIndex() {
		
		if(this.currentIndex <= 1){
			this.preIndex = 0;
		}else{
			this.preIndex = this.currentIndex -1;
		}
		
		return preIndex;
	}

	/**
	 * @return
	 */
	public List<T> getItems() {
		return items;
	}
	
	/**
	 * @param items
	 */
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public <K> Page<K> changePage(PageItemChange<T, K> pageItemChange){
		
		List<K> kItems = new ArrayList<K>();
		
		for(T t : this.items){
			K k = pageItemChange.change(t);
			kItems.add(k);
		}
		
		Page<K> p = new Page<K>(this.totalNumber,this.currentIndex,this.pageSize,kItems);
		
		return p;
	}
	
}
