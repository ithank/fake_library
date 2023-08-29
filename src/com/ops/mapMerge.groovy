#!groovy
package com.ops

Map merge(Map... maps) {
    Map result

    if (maps.length == 0) {
        result = [:]
    } else if (maps.length == 1) {
        result = maps[0]
    } else {
        result = [:]
        maps.each { map ->
            map.each { k, v ->
                result[k] = result[k] instanceof Map ? merge(result[k], v) : v
            }
        }
    }

    result
}
