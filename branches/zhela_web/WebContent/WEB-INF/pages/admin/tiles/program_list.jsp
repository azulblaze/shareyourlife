<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <div id="content">
    	<div class="search">
            <form class="main-search">
                <label for="search-field" class="search-field-label">搜索</label>
                <input type="text" tabindex="1" maxlength="255" class="search-field" value="根据标题查找新闻"/>
                <input type="image" alt="Search" value="Search" src="/images/search.png" class="search-button"/>  
            </form>
        </div>
    	<div class="result">
        	<table class="list" width="100%">
			<thead>
				<tr>
					<th scope="col">Design Name</th>
					<th scope="col">Author</th>
					<th scope="col">Country</th>
					<th scope="col">Comment</th>
					<th scope="col">Download</th>
				</tr>
			</thead>	
			<tfoot>
				<tr>
					<th scope="row">Total</th>
					<td colspan="4">85 designs</td>
				</tr>
			</tfoot>
			<tbody>
								<tr >
					<td><a href="index.php?css=101#r101">Classic yet somehow fancy</a></td>
					<td><a href="twitter.com/radubilei">Radu</a></td>
					<td>Rom&Atilde;&cent;nia</td>
					<td>Monochrome classy-ness with a touch of CSS3</td>
					<td><a href="https://dl.getdropbox.com/u/300539/tabeluMeu.css" title="Download the Classic yet somehow fancy CSS file">Download</a></td>
				</tr>
								<tr class="odd">
					<td><a href="index.php?css=100#r100">rows table template</a></td>
					<td><a href="www.adobati.it">Omar '0m4r' Adobati</a></td>
					<td>Italy</td>
					<td>Simple, clean and a quite classic table template :)</td>
					<td><a href="http://www.adobati.it/labs/CSSTable/0m4r.table.css" title="Download the rows table template CSS file">Download</a></td>
				</tr>
					<tr >
					<td><a href="index.php?css=99#r99">Blue Dream</a></td>
					<td><a href="http://www.admixweb.com">Teylor Feliz</a></td>
					<td>USA</td>
					<td>Beautiful combination of Blue and Brown.</td>
					<td><a href="http://www.admixweb.com/downloads/csstablegallery/bluedream.css" title="Download the Blue Dream CSS file">Download</a></td>
				</tr>
             </tbody>
        </table>
        </div>
    </div>