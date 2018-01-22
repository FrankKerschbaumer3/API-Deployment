package edge.labs.sprints

object SprintSplitter {

    /**
     * Split the given list of stories to Sprints with at most maxVelocity points in each
     */
    fun splitToSprints(stories: List<Story>, maxVelocity: Int): List<Sprint> {
        val totalEstimate = stories.sumBy { s -> s.estimate }

        // Short-circuit for simple case
        if(totalEstimate <= maxVelocity) {
            return listOf(Sprint(0, 1, stories))
        }

        // TODO Partition into sprints
        return listOf()
    }

}