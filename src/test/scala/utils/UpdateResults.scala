package utils

import org.influxdb.InfluxDBFactory
import org.influxdb.dto.Point

object UpdateResults {
  val INFLXUDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root")
  val DB_NAME = "test_results"
  INFLXUDB.setDatabase(DB_NAME)

  def post(point: Point): Unit = {

    INFLXUDB.write(point)
  }
}
