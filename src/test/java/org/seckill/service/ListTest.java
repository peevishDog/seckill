/**
 * 文件名:ListCompera.java
 * 包名:org.seckill.service
 * 创建时间:2017年3月9日下午5:57:21
 * <p>Copyright ®医界互联 TUS 平台版权所有。</p>
 *
*/

package org.seckill.service;

import java.util.ArrayList;
import java.util.List;

public class ListTest{
	public static void main(String[] args){
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		boolean bo = list.contains("a");
		boolean boo = list.contains("c");
		boolean bob = list.contains("d");
		System.out.println(bo);
		System.out.println(boo);
		System.out.println(bob);
	}
	
}
