class NotesMenu(private val app: NotesApp) {
    private val menu = Menu()

    init {
        val archive = app.currentArchive
        if (archive != null) {
            menu.addItem("Добавить заметку") { app.addNoteToArchive(archive); false }
            println("Список заметок:")
            archive.notes.forEachIndexed { index, note ->
                menu.addItem(note.text) { app.selectNoteInArchive(index + 1); false }
                //menu.addItem("Заметка ${index + 1}: ${note.text}") { app.selectNoteInArchive(index + 1); false } //Если вдруг надо нумеровать заметки. Либо это мусор - удалить.
            }
            menu.addItem("Выход") { true }
        }
    }

    fun show() {
        menu.show()
    }

    fun executeOption(option: Int): Boolean {
        return menu.executeOption(option)
    }
}

class Note(val text: String)
