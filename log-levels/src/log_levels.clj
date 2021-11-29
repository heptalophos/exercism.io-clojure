(ns log-levels
  (:require [clojure.string :refer [lower-case join trim]]))

(defn- log-line-parse 
  [log-line]
  (let [log-line-part (re-find #"\[(\w+)\]:\s*(.+)" log-line)]
   { :log-level (lower-case (log-line-part 1)) :message (trim (log-line-part 2)) }
  ))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (-> s log-line-parse :message))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (-> s log-line-parse :log-level))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  ;; (join nil [(message s) \space \( (log-level s) \)]))
  (format "%s (%s)" (message s) (log-level s)))
  
