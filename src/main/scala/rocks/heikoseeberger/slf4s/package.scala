/*
 * Copyright 2021 Heiko Seeberger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package rocks.heikoseeberger.slf4s

import org.slf4j.MDC

/**
  * Adds the given entries to the MDC, then evaluates the given chunck and finally removes the
  * entries again.
  * @param keyAndValue
  *   MDC entry
  * @param moreKeyAndValue
  *   more MDC entries
  * @param chunk
  *   code to be evaluated
  */
def withMDC[A](keyAndValue: (String, String), moreKeyAndValue: (String, String)*)(
    chunk: => A
): Unit =
  val map = moreKeyAndValue.toMap + keyAndValue
  try
    map.foreach(MDC.put(_, _))
    chunk
  finally map.foreach((key, _) => MDC.remove(key))
