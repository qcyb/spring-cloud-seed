package com.ycw.article.vo.param;

import javax.validation.constraints.NotNull;

import com.ycw.common.base.BaseVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @类名称 ArticleListVO
 * @类描述 <pre>【文章表】ListVO</pre>
 * @作者 yuminjun
 * @创建时间 2019年09月17日
 * @版本 v1.00
 * @修改记录 <pre>
 * 版本     		修改人 	修改时间    	 	修改内容	描述
 * ----------------------------------------------
 * 1.00 	yuminjun     	2019年09月17日 	新建
 * ----------------------------------------------
 * </pre>
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserArticleListParamVO extends BaseVO{

	private static final long serialVersionUID = 1L;

 	/**
 	 *用户id
 	 */
	@NotNull(message = "用户id不能为空")
	private Long createUser;


}
