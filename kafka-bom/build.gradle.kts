plugins {
  `java-platform`
  id("org.hypertrace.publish-plugin")
}


var kafkaVersion = "7.5.2"
var kafkaCcsVersion = "$kafkaVersion-ccs"
var protobufVersion = "3.21.7"

dependencies {
  constraints {
    api("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    api("org.xerial.snappy:snappy-java:1.1.10.5") {
      because("[https://nvd.nist.gov/vuln/detail/CVE-2023-34455] in 'org.apache.kafka:kafka-clients:*'")
      because("[https://nvd.nist.gov/vuln/detail/CVE-2023-43642]")
    }
    api("com.google.protobuf:protobuf-java-util:3.21.7") {
      because("https://nvd.nist.gov/vuln/detail/CVE-2022-3171")
    }
    api("com.squareup.okio:okio:3.4.0") {
      because("https://nvd.nist.gov/vuln/detail/CVE-2023-3635 in io.confluent:kafka-protobuf-serializer:7.4.0")
    }
    api("org.apache.commons:commons-compress:1.24.0") {
      because("https://nvd.nist.gov/vuln/detail/CVE-2023-42503")
    }

    api("io.confluent:kafka-streams-avro-serde:$kafkaVersion")
    api("io.confluent:kafka-protobuf-serializer:$kafkaVersion")
    api("io.confluent:kafka-avro-serializer:$kafkaVersion")
    api("io.confluent:kafka-streams-protobuf-serde:$kafkaVersion")
    api("org.apache.kafka:kafka-clients:$kafkaCcsVersion")
    api("org.apache.kafka:kafka-streams:$kafkaCcsVersion")
    api("org.apache.kafka:kafka-streams-test-utils:$kafkaCcsVersion")
    api("org.apache.avro:avro:1.11.3")
  }
}
