<#--
root��������
	treeName���ڵ����ƣ�
	id���ڵ�id��ʹ�ø�ѡ��ʱ��Ҫʹ�ã�
	treeUrl���ڵ����ӣ�${base+node.treeUrl!}${suffix}����
	isLeaf���Ƿ�Ҷ�ӽڵ㣬��Ҫ���ڶ�̬��������ΪNULL�����Ƿ����ӽڵ㣻
	child���ӽڵ㡣
treeId������ID����һ��ҳ���ж����ʱ����Ҫʹ�á�
target��Ŀ�ꡣ���Ӵ򿪵�Ŀ��frame��
showDeep��չ����ȡ�0��չ����
isCheckBox���Ƿ��Ǹ�ѡ��
checkBoxName����ѡ������ơ�
valueContent��ֵ���ϣ�ָʾ��ѡ���Ƿ�ѡ�С�
isUrl���Ƿ������ӡ�
suffix�����Ӻ�׺��
-->
<#macro tree root treeId="t" target="rightFrame" showDeep=0 
	isCheckBox=false checkBoxName="ids" vld="" valueContent=[]
	childName="child" treeName="node.treeName"
	url="" durl="" params={} dparams={} prefix=base suffix=".do" isUrl=true>
<#assign _tree_params=params/>
<#assign _tree_dparams=dparams/>
<#assign _tree_child_name=childName/>
<#assign _tree_tree_name=treeName/>
<#assign _checkbox_vld=vld/>
<div id="${treeId}" class="pn-tree">
<@drawNode node=root treeId=treeId pid=treeId target=target showDeep=showDeep 
	isCheckBox=isCheckBox checkBoxName=checkBoxName valueContent=valueContent 
	url=url durl=durl prefix=prefix suffix=suffix isUrl=isUrl/>
</div>
</#macro>
<#--
DIV��ID�������򼰽ṹ��
<pid-index>�����壩
	<pid-index-s>��self������
		<�հ���><������><�ڵ���><������>
	</pid-index-s>
	<pid-index->���Ӽ���
		...
	</pid-index->
</pid-index>
node���ڵ�
deep�����
isEndList�����Ƚڵ��Ƿ�Ϊĩ�ڵ�
pid������ID
index����ǰ������
-->
<#macro drawNode node pid treeId target showDeep isCheckBox checkBoxName valueContent 
	url durl prefix suffix isUrl
	deep=0 isEndList=[true] index=0>
<#local id=pid+'-'+index />
<#if showDeep gt deep>
	<#local isDisplay=true />
<#else>
	<#local isDisplay=false />
</#if>
<div id="${id}">
<div id="${id}-s" onmouseover="Pn.Tree.lineOver(this)" onmouseout="Pn.Tree.lineOut(this)" onclick="Pn.Tree.lineSelected(this,'${treeId}');" isDisplay="${isDisplay?string}">
<#--�ո���-->
<#if deep gt 0>
<img src="${base+'/core_res/img/tree/s.gif'}" width="15px" /><#t/>
</#if>
<#--ֱ����-->
<#if deep gt 1>
	<#list 2..deep as i>
		<#if isEndList[i-1]>
			<img src="${base+'/core_res/img/tree/s.gif'}" width="15px" /><#t/>
		<#else>
			<img src="${base+'/core_res/img/tree/elbow-line.gif'}" /><#t/>
		</#if>
	</#list>
</#if>
<#--�ڵ���-->
<#if node.treeLeaf??>
	<#assign isLeaf=node.treeLeaf/>
<#elseif (node[_tree_child_name])??>
	<#assign isLeaf=!(node[_tree_child_name]?size>0)/>
<#else>
	<#assign isLeaf=true/>
</#if>
<#if isDisplay>
	<#local openDisplay="" />
	<#local closeDisplay="display:none;" />
<#else>
	<#local openDisplay="display:none;" />
	<#local closeDisplay="" />
</#if>
<#if isLeaf && isEndList[deep]>
	<img src="${base+'/core_res/img/tree/elbow-end.gif'}" /><img src="${base+'/core_res/img/tree/leaf.gif'}" /><#t/>
<#elseif isLeaf && !isEndList[deep]>
	<img src="${base+'/core_res/img/tree/elbow.gif'}" /><img src="${base+'/core_res/img/tree/leaf.gif'}" /><#t/>
<#elseif !isLeaf && isEndList[deep]>
	<img id="${id}-co" src="${base+'/core_res/img/tree/elbow-end-minus.gif'}" onclick="Pn.Tree.switchDisplay('${id}')" style="cursor:pointer;${openDisplay}"/><#t/>
	<img id="${id}-cc" src="${base+'/core_res/img/tree/elbow-end-plus.gif'}" onclick="Pn.Tree.switchDisplay('${id}')" style="cursor:pointer;${closeDisplay}"/><#t/>
	<img id="${id}-fo" src="${base+'/core_res/img/tree/folder-open.gif'}" style="${openDisplay}"/><#t/>
	<img id="${id}-fc" src="${base+'/core_res/img/tree/folder.gif'}" style="${closeDisplay}"/><#t/>
<#elseif !isLeaf && !isEndList[deep]>
	<img id="${id}-co" src="${base+'/core_res/img/tree/elbow-minus.gif'}" onclick="Pn.Tree.switchDisplay('${id}')" style="cursor:pointer;${openDisplay}"/><#t/>
	<img id="${id}-cc" src="${base+'/core_res/img/tree/elbow-plus.gif'}" onclick="Pn.Tree.switchDisplay('${id}')" style="cursor:pointer;${closeDisplay}"/><#t/>
	<img id="${id}-fo" src="${base+'/core_res/img/tree/folder-open.gif'}" style="${openDisplay}"/><#t/>
	<img id="${id}-fc" src="${base+'/core_res/img/tree/folder.gif'}" style="${closeDisplay}"/><#t/>
</#if>
<#if isCheckBox>
<input type="checkbox" name="${checkBoxName}" <#rt/>
	<#if valueContent?seq_contains(node.id)>checked="true"</#if><#lt/>value="${node.id}" id="${id}-chk" vld="${_checkbox_vld}" class="pntree-checkbox" size="0" hidefocus="true" onclick="Pn.Tree.switchSelect(this,'${id}','${treeId}');" /><#t/>
</#if>
<#--������-->
<#if !isLeaf>
<#if !isCheckBox>
&nbsp;<#t/>
</#if>
<#if (node.treeUrl?? && node.treeUrl!='') || durl!=''>
<a href="${prefix+(durl!node.treeUrl)+suffix}<#rt/>
<#list _tree_dparams?keys as pa>
<#if pa_index==0>?<#else>&</#if>${pa}=${node[_tree_dparams[pa]]!}<#rt/>
</#list>
" target="${target}" onclick="Pn.Tree.switchDisplay('${id}',true)">${_tree_tree_name?eval}</a>
<#else>
<span onclick="Pn.Tree.switchDisplay('${id}')" style="cursor:pointer;">${_tree_tree_name?eval}</span>
</#if>
</div>
<#--�ӽڵ㿪ʼ-->
<div id="${id+'-'}" style="${openDisplay}">
<#if node[_tree_child_name]??>
<#list node[_tree_child_name] as cnode>
<@drawNode node=cnode pid=id target=target treeId=treeId showDeep=showDeep 
	isCheckBox=isCheckBox checkBoxName=checkBoxName valueContent=valueContent 
	url=url durl=durl prefix=prefix suffix=suffix isUrl=isUrl 
	deep=deep+1 isEndList=isEndList+[!cnode_has_next] index=cnode_index />

</#list>
</#if>
</div>
<#else>
<#if isCheckBox || !isUrl>
<span>${_tree_tree_name?eval}</span>
<#else>
&nbsp;<a href="${prefix+(url!node.treeUrl)+suffix}<#rt/>
<#list _tree_params?keys as pa>
<#if pa_index==0>?<#else>&</#if>${pa}=${node[_tree_params[pa]]!}<#rt/>
</#list>
" target="${target}">${_tree_tree_name?eval}</a>
</#if>
</div>
</#if>
</div>
</#macro>