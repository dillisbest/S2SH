package org.dusong.edm.tool;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.servlet.http.HttpServletRequest;

public class PageBean {
  private final Log logger = LogFactory.getLog(getClass());

  /**
   * 对查询数据封装
   */
  private ArrayList objList = new ArrayList();
  /**
   * 页面记录大小
   */
  private int pageSize = 5;
  /**
   * 总行数
   */
  private int rowcnt;
  /**
   * 当前页码
   */
  private int currentPage;
  /**
   * 分页信息
   */
  private String pageInfo;

  /**
   * 获得当前页
   * @return
   */
  public int getCurrentPage() {
    return currentPage;
  }
  /**
   * 设置当前页
   * @param currentPage
   */
  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }
  /**
   * 得到页面大小
   * @return
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * 设置页面大小
   * @param pageSize
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * 得到数据
   * @return
   */
  public ArrayList getObjList() {
    return objList;
  }
  /**
   * 设置数据
   * @param objList
   */
  public void setObjList(ArrayList objList) {
    this.objList = objList;
  }
  /**
   * 设置页面信息
   * @param pageInfo
   */
  public void setPageInfo(String pageInfo) {
    this.pageInfo = pageInfo;
  }

  /**
   * 实现下拉框数字翻页
   * @param pageNum 当前页号
   * @param lastPageNum 总的页号
   * @return
   */
  private String getSelect(int pageNum, int lastPageNum) {
    String select = "跳到<select name=temp onchange=\"prePage(this.value)\">";
    select = select + "<option value=" + pageNum + ">" + pageNum + "</option>";
    for (int i = 1; i <= lastPageNum; i++) {
      if (i != pageNum) {
        select = select + "<option value=" + i + ">" + i + "</option>";
      }
    }
    select = select + "</select>页";
    return select;
  }

  /**
   * 获取翻页信息
   * @param req
   * @return
   */
  public String getPageInfo() {
    int previousPageNum = currentPage - 1;
    int nextPageNum = currentPage + 1;
    int pageCount = rowcnt % this.pageSize;
    if (pageCount == 0) {
      pageCount = rowcnt / pageSize;
    }
    else {
      pageCount = rowcnt / pageSize + 1;
    }

    if (pageCount < 1) {
      pageCount = 1;
    }
    pageInfo = "当前第<font color=\"red\">" + currentPage +
        "</font>页&nbsp&nbsp共<font color=\"red\">" + pageCount +
        "</font>页&nbsp&nbsp";
    String first = "<a href =\"#\" onclick=\"prePage('" + 1 +
        "')\">首页&nbsp</a>";
    String previous = "<a href =\"#\" onclick=\"prePage('" + previousPageNum +
        "')\">前一页&nbsp</a>";
    String next = "<a href =\"#\" onclick=\"prePage('" + nextPageNum +
        "')\">下一页&nbsp</a>";
    String last = "<a href =\"#\" onclick=\"prePage('" + pageCount +
        "')\">末页</a>";
    if (currentPage != 1) {
      pageInfo = pageInfo.concat(first).concat(previous);
    }
    if (currentPage != pageCount) {
      pageInfo = pageInfo.concat(next).concat(last);
    }
    pageInfo = pageInfo + getSelect(currentPage, pageCount);
    pageInfo += " <input name=\"pagenum\" type=\"hidden\">\r\n";
    String script = "<script>\r\n";
    script += "function prePage(pageNum){\r\n"; // document.all["pageNum"].value=pageNum;
    script += "document.all[\"pagenum\"].value=pageNum;\r\n";
    script += "document.forms[0].submit();\r\n";
    script += "}\r\n";
    script += "</script>";
    pageInfo = pageInfo + script;
    return pageInfo == null ? "" : pageInfo;
  }

  /**
   * 设置当前页码
   * @param httpServletRequest
   */
  public void setPageNum(HttpServletRequest httpServletRequest) {
    String pageNum = httpServletRequest.getParameter("pagenum");
    try {
      this.setCurrentPage(Integer.parseInt(pageNum));
    }
    catch (Exception ex) {
      this.setCurrentPage(1);
    }
  }
  /**
   * 得到总行数
   * @return
   */
  public int getRowcnt() {

    return rowcnt;
  }

  /**
   * 设置总行数
   * @param rowcnt
   */
  public void setRowcnt(int rowcnt) {
    this.rowcnt = rowcnt;
  }
}
