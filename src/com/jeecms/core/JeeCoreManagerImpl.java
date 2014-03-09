package com.jeecms.core;

import java.io.Serializable;

import com.jeecms.common.hibernate3.BaseManagerImpl;

public class JeeCoreManagerImpl<T extends Serializable> extends
		BaseManagerImpl<T> implements JeeCoreManager<T> {
}
