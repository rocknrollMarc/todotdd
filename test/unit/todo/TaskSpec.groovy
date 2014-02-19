package todo

import grails.test.mixin.TestFor

import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Task)
class TaskSpec extends Specification {
  
  @Unroll
  def "search() should return #count results for query '#query'"
    given:
    [
      new Task(description: "Buy Milk"),
      new Task(description: "Buy bread"),
    ]*.save()
    expect:
      count == Task.search(query).count()
    where:
      count   |   query
      2       |   null
      2       |   "Buy"
      1       |   "Bread"
      0       |   "iPod"
  }

