class ArchivesMenu(private val app: NotesApp) {
    private val menu = Menu()

    init {
        menu.addItem("Создать архив") { app.createArchive(); false }
        println("Список архивов:")
        app.archives.forEachIndexed { index, archive ->
            menu.addItem(archive.name) { app.selectArchive(index + 1); false }
            //menu.addItem("Архив ${index + 1}: ${archive.name}") { app.selectArchive(index + 1); false } //Если вдруг надо нумеровать заметки. Либо это мусор - удалить.
        }
        menu.addItem("Выход") { true }
    }

    fun show() {
        menu.show()
    }

    fun executeOption(option: Int): Boolean {
        return menu.executeOption(option)
    }
}

class Archive(val name: String) {
    val notes: MutableList<Note> = mutableListOf()
}
