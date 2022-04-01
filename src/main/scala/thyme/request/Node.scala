package thyme.request

import thyme.request.context.Context
import thyme.response.Complete

case class Node(path: StringBuilder = new StringBuilder,
                method: String,
                handler: Context => Complete)
