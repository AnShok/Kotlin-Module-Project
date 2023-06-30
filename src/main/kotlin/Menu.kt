class Menu {
    private val items: MutableList<Pair<String, () -> Boolean>> = mutableListOf()

    fun addItem(text: String, action: () -> Boolean) {
        items.add(Pair(text, action))
    }

    fun show() {
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.first}")
        }
    }

    fun executeOption(option: Int): Boolean {
        if (option in 1..items.size) {
            return items[option - 1].second.invoke()
        }
        println("Неверный Ввод. Пожалуйста, введите правильный вариант.")
        return false
    }
}

