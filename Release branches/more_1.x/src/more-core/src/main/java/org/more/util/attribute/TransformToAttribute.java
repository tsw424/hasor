/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.more.util.attribute;
import java.util.HashMap;
import java.util.Map;
/**
 * �����ְ���ǽ�{@link Map}�ӿڶ���ת��Ϊ{@link IAttribute}�ӿڶ���
 * ������ע�⣬{@link Map}��Key����ΪString���ͷ�������޷�ͨ���ַ�����ʽ��Key��ȡ��ֵ��
 * Date : 2011-4-12
 * @author ������ (zyc@byshell.org)
 */
public class TransformToAttribute<T> implements IAttribute<T> {
    private Map values = null;
    /**����һ��{@link TransformToAttribute}���󣬸ö���������ǽ�{@link Map}ת��Ϊ{@link IAttribute}�ӿڡ�*/
    public TransformToAttribute(Map values) {
        if (values == null)
            throw new NullPointerException();
        this.values = values;
    };
    public boolean contains(String name) {
        return this.values.containsKey(name);
    };
    public void setAttribute(String name, T value) {
        this.values.put(name, value);
    };
    public T getAttribute(String name) {
        return (T) this.values.get(name);
    };
    public void removeAttribute(String name) {
        this.values.remove(name);
    };
    public String[] getAttributeNames() {
        String[] KEYS = new String[this.values.size()];
        int i = 0;
        for (Object k : this.values.keySet()) {
            KEYS[i] = (k != null) ? k.toString() : null;
            i++;
        }
        return KEYS;
    };
    public void clearAttribute() {
        this.values.clear();
    }
    public Map<String, T> toMap() {
        HashMap<String, T> map = new HashMap<String, T>();
        for (Object key : this.values.keySet())
            if (key != null)
                map.put(key.toString(), (T) this.values.get(key));
            else
                map.put(null, (T) this.values.get(key));
        return map;
    }
    public int size() {
        return this.values.size();
    };
};