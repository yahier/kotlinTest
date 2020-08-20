package com.example.kotlintest.grammer

import kotlin.reflect.KProperty


/**
 * 属性代理
 */
class DelegatePropertiesDemo2 {
    var content: String by Content()

    override fun toString(): String {
        return "DelegatePropertiesDemo Class"
    }
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo2, property: KProperty<*>): String {
        return "${delegatePropertiesDemo} property '${property.name}' = 'Balalala ... ' "
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo2, property: KProperty<*>, value: String) {
        println("${delegatePropertiesDemo} property '${property.name}' is setting value: '$value'")
    }
}

fun main(args: Array<String>) {
    val delegatePropertiesDemo = DelegatePropertiesDemo2()
    println(delegatePropertiesDemo.content)
    delegatePropertiesDemo.content = "abc"
}