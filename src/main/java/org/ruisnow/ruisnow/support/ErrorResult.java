package org.ruisnow.ruisnow.support;

import java.util.HashMap;
import java.util.Map;

public class ErrorResult extends BaseResult<Map<String, Object>>{

    @Override
    public Map<String, Object> getData() {
        return new HashMap<>();
    }
}
