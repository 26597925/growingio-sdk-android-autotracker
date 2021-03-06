/*
 * Copyright (C) 2020 Beijing Yishu Technology Co., Ltd.
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

package com.growingio.android.sdk.autotrack.events;

import com.growingio.android.sdk.autotrack.events.base.BaseViewElement;

import org.json.JSONException;
import org.json.JSONObject;

public final class ViewElement extends BaseViewElement {
    private static final long serialVersionUID = 1L;

    private final String mCid;

    ViewElement(ElementBuilder elementBuilder) {
        super(elementBuilder);
        mCid = elementBuilder.mCid;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject json = super.toJSONObject();

        try {
            json.put("mCid", mCid);
        } catch (JSONException ignored) {
        }

        return json;
    }

    public final static class ElementBuilder extends BaseViewElement.BaseElementBuilder<ViewElement> {
        private String mCid;

        public String getCid() {
            return mCid;
        }

        public ElementBuilder setCid(String cid) {
            mCid = cid;
            return this;
        }

        @Override
        public ViewElement build() {
            return new ViewElement(this);
        }
    }
}
