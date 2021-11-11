package solutions

import api.Task

class Lesson2LuckyTickets : Task {
    override fun run(data: List<String>): String {
        return data.firstOrNull()?.length.toString()
    }
}